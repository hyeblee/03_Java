package com.ohgiraffers.hw2.model.Comparator;

import com.ohgiraffers.hw2.model.dto.BoardDTO;
import java.util.Comparator;

public class DescBoardDate implements Comparator<BoardDTO> {

  @Override
  public int compare(BoardDTO o1, BoardDTO o2) {
    return o2.getBoardDate().compareTo(o1.getBoardDate());
  }
}
