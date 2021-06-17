package config;

import config.enums.UnitColour;
import config.enums.UnitDirections;

public abstract class Assets
{
	protected String sign;
    protected int row;
    protected int col;
    protected int attack;
    protected int armour;
    protected int health;
    protected int attackRange;
    protected int moveSpeed;
    protected UnitColour colour;
    protected String unitName;

    public Assets(String sign, int row, int col, int attack, int armour, int health, int attackRange, int moveSpeed, UnitColour colour)
    {
        this.sign=sign;
        this.row=row;
        this.col=col;
        this.attack=attack;
        this.armour=armour;
        this.health=health;
        this.attackRange=attackRange;
        this.moveSpeed=moveSpeed;
        this.colour=colour;
}
    
    public Assets(String sign,int row,int col)
    {
        this.sign=sign;
        this.row=row;
        this.col=col;
    }
    
    public String getPlayerColourPrefix()
    {
        if(this.colour==UnitColour.BLACK)
            return "B";
        else if(this.colour==UnitColour.RED)
            return "R";
        return " ";
    }

    public String getUnitSymbol() 
    {
        return this.getPlayerColourPrefix()+this.sign;
    }

    public void move(int moveRow, int moveCol) 
    {
        this.row=moveRow;
        this.col=moveCol;
    }

    public void getUnitStatistics()
    {
        System.out.println("Избраната фигура е от тип: "+this.unitName);
        System.out.println("Избраната фигура има "+this.health+" кръв.");
        System.out.println("Избраната фигура има "+this.armour+" броня.");
        System.out.println("Избраната фигура ще нанася щети, които ще вземат "+this.attack+" точки от състоянието на противника.");
        System.out.println("Избраната фигура ще нанася шети, само ако противникът е в диапазон от "+this.attackRange+" блокове.");
        System.out.println("Избраната фигура може да се мести по игралното поле с по "+this.moveSpeed+" блокове.");
    }

    public abstract boolean isMovePossible(UnitDirections input, int toRow, int toCol);

    public abstract boolean isAttackPossible(int toRow, int toCol);
}
