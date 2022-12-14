package com.ssafy.home.board.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssafy.home.board.dto.BoardDto;
import com.ssafy.home.board.dto.BoardListDTO;
import com.ssafy.home.board.dto.BoardUpdateInputDTO;
import com.ssafy.home.board.dto.WriteBoardDTO;
import com.ssafy.home.board.service.BoardService;
import com.ssafy.home.common.dto.ResponseDTO;
import com.ssafy.home.member.dto.UserAuth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api(tags = {"board"})
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor // 생성자 주입
public class BoardController {
    private final BoardService boardService; // 생성자 주입을 위한 처리

    @DeleteMapping("delete")
    public ResponseEntity<ResponseDTO> delete(
            String code
    ) {
        ResponseDTO res = new ResponseDTO();
        System.out.println(code);
        try {
            int result = boardService.delete(code);
            res.setMsg("게시글이 삭제 되었습니다!");
            res.setStatusCode(200);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.setErrMsg("게시판 삭제 실패");
            res.setStatus("fail");
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "게시글 code를 사용한 게시글 업데이트")
    @PutMapping("update")
    public ResponseEntity<ResponseDTO> update(
            @ApiParam(value = "boardUpdateInputDTO")
            @RequestBody BoardUpdateInputDTO boardUpdateInputDTO)
            throws Exception {
        ResponseDTO res = new ResponseDTO();
        boardService.updateBoard(boardUpdateInputDTO);
        res.setStatusCode(200);
        res.setMsg("success");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 code를 이용한 게시글 상세 보기")
    @PostMapping("detail")
    public ResponseEntity<ResponseDTO> detail(
            @ApiParam("code")
            String code) {

        ResponseDTO res = new ResponseDTO();
        Map<String, Object> map = new HashMap<>();
        BoardDto board = boardService.select(code);
        if (board == null) {
            res.setStatusCode(404);
            res.setErrMsg("not found");
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
        res.setBody(board);
        res.setMsg("success");
        res.setStatusCode(200);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 작성하기")
    @PostMapping("upload")
    public ResponseEntity<ResponseDTO> write(
            @RequestBody
            @ApiParam(value = "board")
            WriteBoardDTO board,
            HttpServletRequest req) {
        ResponseDTO res = new ResponseDTO();
        UserAuth userAuth = (UserAuth) req.getAttribute("auth");
        if (board.getContent().isEmpty() || board.getTitle().isEmpty()) {
            res.setStatus("fail");
            res.setStatusCode(404);
            res.setErrMsg("내용과 제목을 입력해 주세요");
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        boardService.writeBoard(board, userAuth.getId());
        res.setStatusCode(200);
        res.setStatus("success");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 전체 조회하기")
    @PostMapping("/selectall")
    public PageInfo<?> selectAll(
            @RequestBody
            BoardListDTO boardListDTO) {
        PageHelper.startPage(boardListDTO);
        List<BoardDto> list = boardService.selectAll();
        System.out.println(list);
        return PageInfo.of(list);
    }
}
