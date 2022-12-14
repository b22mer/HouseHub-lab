package com.ssafy.home.board.service;

import com.ssafy.home.board.dto.BoardDto;
import com.ssafy.home.board.dto.BoardUpdateInputDTO;
import com.ssafy.home.board.dto.WriteBoardDTO;
import com.ssafy.home.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public List<BoardDto> selectAll() {
        return boardMapper.selectAll();
    }

    @Transactional
    public void writeBoard(WriteBoardDTO writeBoardDTO, String id) {
//        List<FileDTO> list = board.getFileInfos();

//        if (list!=null && !list.isEmpty()){
//            boardMapper.addFile(board);
//        }
        BoardDto board = new BoardDto();
        board.setContent(writeBoardDTO.getContent());
        board.setTitle(writeBoardDTO.getTitle());
        board.setWriter(writeBoardDTO.getWriter());
        board.setCode(UUID.randomUUID().toString());
        board.setId(id);
        boardMapper.writeBoard(board);
    }

    public BoardDto select(String code) {
        return boardMapper.select(code);
    }

    public void updateBoard(BoardUpdateInputDTO boardDto) {
        boardMapper.update(boardDto);
    }

    public int delete(String code) {
        return boardMapper.boardDelete(code);
    }
}
