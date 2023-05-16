package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.w3c.dom.Text;

/**
 * 记事本对象 todolist
 * 
 * @author ljn
 * @date 2023-05-14
 */

public class Todolist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 内容 */
    @Excel(name = "内容")
    private String text;

    /** 是否完成 */
    @Excel(name = "是否完成")
    private boolean done;

    public Todolist(){

    }
    public Todolist(String text,boolean done){
        this.text=text;
        this.done=done;
    }
    public Todolist(Long id, String text,boolean done){
        this.id=id;
        this.text=text;
        this.done=done;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setText(String text) 
    {
        this.text = text;
    }

    public String getText() 
    {
        return text;
    }
    public void setDone(boolean done)
    {
        this.done = done;
    }

    public boolean getDone()
    {
        return done;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("text", getText())
            .append("done", getDone())
            .toString();
    }
}
