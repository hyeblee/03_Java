package com.ohgiraffers.hw2.view;

import com.ohgiraffers.hw2.model.dto.BoardDTO;
import java.util.ArrayList;

public class ResultPrinter {

  public void printAllList(ArrayList<BoardDTO> list) {
    // list에 출력할 내용이 있으면 출력
    if(!list.isEmpty()) {
      for(BoardDTO dto : list) {
        printBoard(dto);
      }
    } else {
    // list에 출력할 내용이 없으면 “게시물이 없습니다” 출력
      System.out.println("게시물이 없습니다");
    }
  }

  }

  public void printBoard(BoardDTO b) {
// 전달받은 내용 출력
  }

  public void errorPage(String msg) {
//    전달받은 문자열에 따라서 실패내용 출력
//    insertBoard : 게시물 등록 실패
//    selectOne: “조회된 글이 없습니다.”
//    updateTitle:”게시물 제목 수정 실패!”
//    updateContent:”게시글 내용 수정 실패!”
//    deleteBoard:”게시글 삭제 실패!”
  }
