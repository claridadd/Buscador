package com.example.buscador.modelos;

import java.sql.Timestamp;

public class Category
{
    private int id;
    private int color;
    private int parent_id;
    private char parent_path;
    private boolean active;
    private Timestamp create_time;
    private Timestamp write_time;

    public Category(int id, int color, int parent_id,  char parent_path, boolean active, Timestamp create_time, Timestamp write_time)
    {
        this.id = id;
        this.color = color;
        this.parent_id = parent_id;
        this.parent_path = parent_path;
        this.active = active;
        this.create_time = create_time;
        this.write_time = write_time;
    }

    public Category()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getColor()
    {
        return color;
    }

    public void setColor(int color)
    {
        this.color = color;
    }

    public int getParent_id()
    {
        return parent_id;
    }

    public void setParent_id(int parent_id)
    {
        this.parent_id = parent_id;
    }


    public char getParent_path()
    {
        return parent_path;
    }

    public void setParent_path(char parent_path)
    {
        this.parent_path = parent_path;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
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
