package com.ohgiraffers.section04.repository;

import com.ohgiraffers.section04.aggregate.BloodType;
import com.ohgiraffers.section04.aggregate.Member;
import com.ohgiraffers.section04.stream.MyObjectOutput;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// 데이터와 입출력(CRUD)을 위해 만들어지며 성공 또는 실패 여부를 반환
public class MemberRepository {

  private ArrayList<Member> memberList = new ArrayList<Member>();

  /*
   * 최초에 생성될 객체의 생성자
   * 1. 초기 회원 세 명을 넣어둘 예정(스트림을 활용한 객체 출력)
   * 2. 파일로부터 회원 정보를 가져온다.(스트림을 활용한 객체 입력)
   * 3. ArrayList를 활용해 가져온 회원정보를 저장
   * */

  public MemberRepository() {
    File file = new File("src/main/java/com/ohgiraffers/section04/db/memberDB.dat");

    // main을 실행할 때마다 덮어씌우는 문제를 방지하고자 파일이 없을 때만 초기 세팅이 되도록 조건문 작성
    if (!file.exists()) {
      ArrayList<Member> defaultMembers = new ArrayList<>();
      defaultMembers.add(
          new Member(1, "user01", "pass01", 20, new String[]{"발레", "수영"}, BloodType.A));
      defaultMembers.add(
          new Member(2, "user02", "pass02", 10, new String[]{"게임", "만화시청"}, BloodType.B));
      defaultMembers.add(
          new Member(3, "user03", "pass03", 15, new String[]{"음악감상", "독서", "명상"}, BloodType.AB));

      saveMembers(file, defaultMembers);
    }
    loadMember(file);
    for (Member member : memberList) {
      System.out.println("Member" + member);
    }
  }

  private void loadMember(File file) {
    // finally 없는 이유는 알아서 close 하고 나가기 때문.
    try (ObjectInputStream ois = new ObjectInputStream(
        new BufferedInputStream(new FileInputStream(file)))) {
      while (true) {
        memberList.add((Member) ois.readObject());
      }
    } catch (EOFException e) {
      System.out.println("회원 정보 모두 로딩됨...");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  // 내부에서만 쓰면 되니까 private
  private void saveMembers(File file, ArrayList<Member> members) {

    ObjectOutputStream oos = null;

    try {
      oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

      for (Member member : members) {
        oos.writeObject(member);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      if (oos != null) {
        try {
          oos.close();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  public ArrayList<Member> selectAllMembers() {
    return memberList;
  }

  public Member selectMemberBy(int memberNo) {
    for (Member member : memberList) {
      if (member.getMemNo() == memberNo) {
        return member;
      }
    }
    return null;
  }

  // MySQL에서 1행 넣으면 1을 리턴, 0을 넣으면 아무것도 할 게 없음, 오류면 음수
  // 양수면 성공, 0이면 반영된게 없다. -1이면 실패
  // 추가, 수정, 삭제 리턴값 서비스한테 알려주기 위해~~
  public int inserMember(Member newMember) {

    MyObjectOutput moo = null;

    int result = -1; // 회원 추가 성공 여부

    try {
      moo = new MyObjectOutput(new BufferedOutputStream( // true면 이어붙이기 하겠다는 뜻
          new FileOutputStream("src/main/java/com/ohgiraffers/section04/db/memberDB.dat", true)));
      // 파일에 쓰기
      moo.writeObject(newMember);

      // 리스트에 추가하기
      memberList.add(newMember);

      // 객체 1개 insert 성공
      result = 1;
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      if (moo != null) {
        try {
          moo.close();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
    }
    return result;
  }

  // insert를 하기 위해 회원번호를 발생시키는데 사용되는 마지막 회원의 번호 추출 기능 메소드
  public int seletLastMemberNo() {
    Member lastMember = memberList.get(memberList.size() - 1);
    System.out.println(lastMember + ": memberList");
    return lastMember.getMemNo();

//    return memberList.size(); 중간에 삽입, 삭제 하면 사이즈가 번호가 아닐수도 있음.
  }

  public int updateMember(Member reform) {

    for (int i = 0; i < memberList.size(); i++) {
      Member iMember = memberList.get(i);
      if (iMember.getMemNo() == reform.getMemNo()) {
        System.out.println("===== 수정 전 기존 회원 정보와 비교 =====");
        System.out.println("reform = " + reform);
        System.out.println("iMember = " + iMember);
        System.out.println("====================================");
        memberList.set(i, reform);

        File file = new File("src/main/java/com/ohgiraffers/section04/db/memberDB.dat");
        saveMembers(file, memberList);

        if (!iMember.equals(reform)) {
          return 1;
        }

      }
    }
    return 0;

  }

  public int deleteMember(int removeMember) {
    /*
    * 현재는 우리가 마지막 회우너 번호 추출을 위해 컬렉션의 size()를 활용하고 있다.
    * 그래서 hard delete(실제 회원 객체 제거)를 할 수 없고
    * soft delete(회원 중에 탈퇴와 관련된 속성 수정)을 진행해야 한다.
    *
    * hard delete를 하게 된다면 ememberList에서 회원 한명을 removE()메소드를 활용하여 삭제하고
    * 파일 객체 출력을 통해 파일에 컬렉션에 있는 회원들을 다시 덮어씌워야 한다. (ObjectOutputStream을 활용해서...)*/

    // soft delete 사용
   /* int result = -1;

    for(Member mem: memberList) {
      if(mem.getMemNo() == removeMember) {
        mem.setId(null);
        result = 1;
      }
    }

    return result;*/

    // hard delete 사용
    for (int i = 0; i < memberList.size(); i++) {
      if(memberList.get(i).getMemNo() == removeMember) {
        memberList.remove(i);

        File file = new File("src/main/java/com/ohgiraffers/section04/db/memberDB.dat");
        saveMembers(file, memberList);

        return 1;
      }
    }
    return 0;
  }

}
