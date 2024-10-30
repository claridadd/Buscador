package com.example.buscador.modelos;

import java.sql.Timestamp;

public class Category
{
    private Integer id;
    private Integer color;
    private Integer parent_id;
    private String parent_path;
    private Boolean active;
    private Timestamp create_time;
    private Timestamp write_time;

    public Category(Integer id, Integer color, Integer parent_id,  String parent_path, Boolean active, Timestamp create_time, Timestamp write_time)
    {
        this.id = id;
        this.color = color;
        this.parent_id = parent_id;
        this.parent_path = parent_path;
        this.active = active;
        this.create_time = create_time;
        this.write_time = write_time;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getColor()
    {
        return color;
    }

    public void setColor(Integer color)
    {
        this.color = color;
    }

    public Integer getParent_id()
    {
        return parent_id;
    }

    public void setParent_id(Integer parent_id)
    {
        this.parent_id = parent_id;
    }


    public String getParent_path()
    {
        return parent_path;
    }

    public void setParent_path(String parent_path)
    {
        this.parent_path = parent_path;
    }

    public Boolean isActive()
    {
        return active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    public Timestamp getCreate_time()
    {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time)
    {
        this.create_time = create_time;
    }

    public Timestamp getWrite_time()
    {
        return write_time;
    }

    public void setWrite_time(Timestamp write_time)
    {
        this.write_time = write_time;
    }
}
