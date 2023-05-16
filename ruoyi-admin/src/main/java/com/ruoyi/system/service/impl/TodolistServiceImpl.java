package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TodolistMapper;
import com.ruoyi.system.domain.Todolist;
import com.ruoyi.system.service.ITodolistService;

/**
 * 记事本Service业务层处理
 * 
 * @author ljn
 * @date 2023-05-14
 */
@Service
public class TodolistServiceImpl implements ITodolistService 
{
    @Autowired
    private TodolistMapper todolistMapper;

    /**
     * 查询记事本
     * 
     * @param id 记事本主键
     * @return 记事本
     */
    @Override
    public Todolist selectTodolistById(Long id)
    {
        return todolistMapper.selectTodolistById(id);
    }

    /**
     * 查询记事本列表
     * 
     * @param todolist 记事本
     * @return 记事本
     */
    @Override
    public List<Todolist> selectTodolistList(Todolist todolist)
    {
        return todolistMapper.selectTodolistList(todolist);
    }

    public List<Todolist> selectTodolistListAll(){
        return todolistMapper.selectTodolistListAll();
    }
    /**
     * 新增记事本
     * 
     * @param todolist 记事本
     * @return 结果
     */
    @Override
    public int insertTodolist(Todolist todolist)
    {
        return todolistMapper.insertTodolist(todolist);
    }

    /**
     * 修改记事本
     * 
     * @param todolist 记事本
     * @return 结果
     */
    @Override
    public int updateTodolist(Todolist todolist)
    {
        return todolistMapper.updateTodolist(todolist);
    }

    /**
     * 批量删除记事本
     * 
     * @param ids 需要删除的记事本主键
     * @return 结果
     */
    @Override
    public int deleteTodolistByIds(Long[] ids)
    {
        return todolistMapper.deleteTodolistByIds(ids);
    }

    /**
     * 删除记事本信息
     * 
     * @param id 记事本主键
     * @return 结果
     */
    @Override
    public int deleteTodolistById(Long id)
    {
        return todolistMapper.deleteTodolistById(id);
    }
}
