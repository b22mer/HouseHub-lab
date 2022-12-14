package com.ssafy.home.board.mapper;

import com.ssafy.home.board.dto.BoardDto;
import com.ssafy.home.board.dto.BoardUpdateInputDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDto> selectAll();

    void writeBoard(BoardDto board);
    void addFile(BoardDto boardDto);

    BoardDto select(String code);

    void update(BoardUpdateInputDTO boardDto);

    int boardDelete(String code);
}
