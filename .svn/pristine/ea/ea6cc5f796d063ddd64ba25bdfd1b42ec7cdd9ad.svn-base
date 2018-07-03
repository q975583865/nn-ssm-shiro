package com.qppi.crud.Enum;

public enum OrderStatus {
	
	HAVEPAID("已支付",0),
	INITIALIZATION("待授权",1),
	
	HAVEAUTH("待复核",2),
	NOTAGREEAUTH("不同意授权",3),
	
	CHECKEDFAIL("不同意复核",4),
	HAVECHECKED("待派工",5),
	
	WORKING("技师开工",6),
	NEEDPARTS("需要零配件",7),
	NOTNEEDPARTS("不需要零配件",8),
	
	WAITCONFIRM("待确认",9),//添加完配件后的状态
	
	AGREEREPAIR("用户同意修",10),
	NOTAGREEREPAIR("用户不同意修",11),
	
	BUYINGPARTS("配件采购中",12),
	/*PARTSREADY("配件准备完毕",13),*/
	
	RESTORED("技师修复完毕待创建工时结算",14),
	PREPAID("待支付",15);
	
	
	
	// 成员变量
	private String name;
	private int index;

	// 构造方法
	private OrderStatus(String name, int index) {
		this.name = name;
		this.index = index;
	}

	// 普通方法
	public static String getName(int index) {
		for (OrderStatus c : OrderStatus.values()) {
			if (c.getIndex() == index) {
				return c.name;
			}
		}
		return null;
	}

	// get set 方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static void main(String[] args) {
		System.out.println(OrderStatus.HAVEPAID.getIndex());
	}

	@Override
	public String toString() {
		return String.valueOf(index);
	}
	
}
