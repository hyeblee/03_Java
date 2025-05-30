package com.ohgiraffers.hw2.model.Comparator;

import com.ohgiraffers.hw2.model.dto.BoardDTO;
import com.ohgiraffers.hw2.view.BoardMenu;
import java.util.Comparator;

public class DescBoardTitle implements Comparator<BoardDTO> {

  @Override
  public int compare(BoardDTO o1, BoardDTO o2) {
    return o2.getBoardTitle().compareTo(o1.getBoardTitle());
  }
}
