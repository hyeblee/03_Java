package com.ohgiraffers.hw2.model.dto;

import java.util.Date;

public class BoardDTO {

  int boardNo;
  String boardTitle;
  String boardWriter;
  Date boardDate;
  String boardContent;
  int readCount;

  public BoardDTO() {
  }

  public BoardDTO(int boardNo, String boardTitle, String boardWriter, Date boardDate,
      String boardContent, int readCount) {
    this.boardNo = boardNo;
    this.boardTitle = boardTitle;
    this.boardWriter = boardWriter;
    this.boardDate = boardDate;
    this.boardContent = boardContent;
    this.readCount = readCount;
  }

  @Override
  public String toString() {
    return "boardNo=" + boardNo +
        ", boardTitle='" + boardTitle + '\'' +
        ", boardWriter='" + boardWriter + '\'' +
        ", boardDate=" + boardDate +
        ", boardContent='" + boardContent + '\'' +
        ", readCount=" + readCount;
  }

  public int getBoardNo() {
    return boardNo;
  }

  public void setBoardNo(int boardNo) {
    this.boardNo = boardNo;
  }

  public String getBoardTitle() {
    return boardTitle;
  }

  public void setBoardTitle(String boardTitle) {
    this.boardTitle = boardTitle;
  }

  public String getBoardWriter() {
    return boardWriter;
  }

  public void setBoardWriter(String boardWriter) {
    this.boardWriter = boardWriter;
  }

  public Date getBoardDate() {
    return boardDate;
  }

  public void setBoardDate(Date boardDate) {
    this.boardDate = boardDate;
  }

  public String getBoardContent() {
    return boardContent;
  }

  public void setBoardContent(String boardContent) {
    this.boardContent = boardContent;
  }

  public int getReadCount() {
    return readCount;
  }

  public void setReadCount(int readCount) {
    this.readCount = readCount;
  }
}
