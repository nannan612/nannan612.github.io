package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Todolist;
import org.apache.ibatis.annotations.Param;

/**
 * 记事本Mapper接口
 * 
 * @author ljn
 * @date 2023-05-14
 */
public interface TodolistMapper 
{

    /**
     * 查询记事本
     * 
     * @param id 记事本主键
     * @return 记事本
     */
    public Todolist selectTodolistById(Long id);

    /**
     * 查询记事本列表
     * 
     * @param todolist 记事本
     * @return 记事本集合
     */
    public List<Todolist> selectTodolistList(Todolist todolist);

    public List<Todolist> selectTodolistListAll();

    /**
     * 新增记事本
     * 
     * @param todolist 记事本
     * @return 结果
     */
    public int insertTodolist(Todolist todolist);

    /**
     * 修改记事本
     * 
     * @param todolist 记事本
     * @return 结果
     */
    public int updateTodolist(Todolist todolist);

    /**
     * 删除记事本
     * 
     * @param id 记事本主键
     * @return 结果
     */
    public int deleteTodolistById(Long id);

    /**
     * 批量删除记事本
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTodolistByIds(Long[] ids);
}
