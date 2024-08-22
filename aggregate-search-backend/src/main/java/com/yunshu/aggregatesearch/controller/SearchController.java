package com.yunshu.aggregatesearch.controller;
import com.yunshu.aggregatesearch.common.BaseResponse;
import com.yunshu.aggregatesearch.common.ResultUtils;
import com.yunshu.aggregatesearch.manager.SearchFacade;
import com.yunshu.aggregatesearch.model.dto.search.SearchRequest;
import com.yunshu.aggregatesearch.model.vo.SearchVO;
import com.yunshu.aggregatesearch.service.PictureService;
import com.yunshu.aggregatesearch.service.PostService;
import com.yunshu.aggregatesearch.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 聚合接口
 */
@RestController
@RequestMapping("/search")
@Slf4j
public class SearchController {

    @Resource
    private UserService userService;

    @Resource
    private PostService postService;

    @Resource
    private PictureService pictureService;

    @Resource
    private SearchFacade searchFacade;

    @PostMapping("/all")
    public BaseResponse<SearchVO> searchAll(@RequestBody SearchRequest searchRequest, HttpServletRequest request) {
        return ResultUtils.success(searchFacade.searchAll(searchRequest, request));
    }

}
