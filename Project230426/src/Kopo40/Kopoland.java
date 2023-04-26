package Kopo40;

import java.util.*;

public class Kopoland {
	Scanner myInput = new Scanner(System.in);
	int ticketType, ticketTime, birthYear, ticketCount, ticketAdvantage;
	int totalPrice = 0, ticketGrade, age;
	final int CURRENT_YEAR = 2018;
	final int FREE_ONEDAY_ADULT = 55000, FREE_ONEDAY_YOUTH = 48000, FREE_ONEDAY_CHILD = 44000, FREE_ONEDAY_BABY = 14000;
	final int FREE_AFTER4_ADULT = 44000, FREE_AFTER4_YOUTH = 38000, FREE_AFTER4_CHILD = 34000, FREE_AFTER4_BABY = 14000;
	final int PARK_ONEDAY_ADULT = 52000, PARK_ONEDAY_YOUTH = 46000, PARK_ONEDAY_CHILD = 43000, PARK_ONEDAY_BABY = 14000;
	final int PARK_AFTER4_ADULT = 41000, PARK_AFTER4_YOUTH = 36000, PARK_AFTER4_CHILD = 33000, PARK_AFTER4_BABY = 14000;
	List<OrderListClass> data = new ArrayList<OrderListClass>();
	OrderListClass orderList = null; 

	void saveData() {
		orderList = new OrderListClass(ticketGrade,
						totalPrice, ticketType, ticketCount);
		data.add(orderList);
	}
	void typeInput() {
		do {
			 System.out.print("������ �Է��ϼ���.\n1.�����̿��\n2.��ũ�̿��\n->\t   ");
		     ticketType = myInput.nextInt();
		}while(  !(ticketType == 1 || ticketType == 2)  );
	}
	
	void typeTime() {
		do {
	        System.out.print("Ƽ�� �ð��� �Է��ϼ���.\n1.1�ϱ�\n2.After4\n->\t");
	        ticketTime = myInput.nextInt();
		}while( !(ticketTime == 1 || ticketTime == 2) );
	}
	
	void input() {
		// �Է�
		typeInput();
		typeTime();
		do {
			System.out.print("����(�¾ ��)�� �Է��ϼ���. : ");
	        birthYear = myInput.nextInt();
		}while( birthYear < 1900   );
		do {
			System.out.print("�� ���� �ֹ��Ͻðڽ��ϱ�? : ");
	        ticketCount = myInput.nextInt();
		}while( ticketCount <= 0 || ticketCount > 10);
		do {
			System.out.print("�������� �Է��ϼ���.\n1.����\n2.�����\n3.����������\n->\t   ");
	        ticketAdvantage = myInput.nextInt();
		}while( !(ticketAdvantage == 1 || ticketAdvantage == 2 || ticketAdvantage == 3) );
	}
	
	
	int calcAge(int currentYear, int birthYear) {
		int result;
		result = currentYear - birthYear + 1;
		return result;
	}
	
	int checkGrade(int age) {
		int result;
		if(age <= 3) {
			result = 3;
        } else if(age <= 12 || age >= 65) {
        	result = 2;
        } else if(age <= 18) {
        	result = 1;
        } else {
        	result = 0;
        }
		return result;
	}
	int checkPrice(int type, int time, int grade) {
		int result = 0;
		if(type == 1) {
        	if(time == 1) {
        		switch(grade) {
        		case 0: 
        			result = FREE_ONEDAY_ADULT;
        			break;
        		case 1:
        			result = FREE_ONEDAY_YOUTH;
        			break;
        		case 2:
        			result = FREE_ONEDAY_CHILD;
        			break;
        		case 3: 
        			result = FREE_ONEDAY_BABY;
        			break;
        		}
        	} else if(time == 2) {
        		if(grade == 0) {
        			result = FREE_AFTER4_ADULT;
        		} else if(grade == 1) {
        			result = FREE_AFTER4_YOUTH;
        		} else if(grade == 2) {
        			result = FREE_AFTER4_CHILD;
        		} else if(grade == 3) {
        			result = FREE_AFTER4_BABY;
        		}
        	}
        } else if(type == 2){
        	if(time == 1) {
        		if(grade == 0) {
        			result = PARK_ONEDAY_ADULT;
        		} else if(grade == 1) {
        			result = PARK_ONEDAY_YOUTH;
        		} else if(grade == 2) {
        			result = PARK_ONEDAY_CHILD;
        		} else if(grade == 3) {
        			result = PARK_ONEDAY_BABY;
        		}
        	} else if(time == 2) {
        		if(grade == 0) {
        			result = PARK_AFTER4_ADULT;
        		} else if(grade == 1) {
        			result = PARK_AFTER4_YOUTH;
        		} else if(grade == 2) {
        			result = PARK_AFTER4_CHILD;
        		} else if(grade == 3) {
        			result = PARK_AFTER4_BABY;
        		}
        	}
        }
		return result;
	}
	void calc() {
		// ���
        age = calcAge(CURRENT_YEAR, birthYear);
        ticketGrade = checkGrade(age);
        // �����̿��
        totalPrice = checkPrice(ticketType, ticketTime, ticketGrade);
        
        // ����
        totalPrice = totalPrice * ticketCount;
        
        // ���
        if(ticketAdvantage == 2) {
        	totalPrice = (int)( (double)totalPrice * 0.48 );
        } else if(ticketAdvantage == 3) {
        	totalPrice = totalPrice / 2;
        }
        
	}
	void output() {
		
		// ���
		System.out.println();
        System.out.println("������ " + totalPrice + "�� �Դϴ�.\n�����մϴ�.");
        System.out.println("================���̰���=================");
        
        for(OrderListClass order : data) {
        	ticketType = order.getTicketType();
        	ticketGrade = order.getTicketGrade();
        	totalPrice = order.getTotalPrice();
        	ticketCount = order.getTicketCount();
        	
			if(ticketType == 1) {
	        	System.out.print("�����̿��\t");
	        } else {
	        	System.out.print("��ũ�̿��\t");
	        }
	        if(ticketGrade == 0) {
	        	System.out.print("� ");
	        } else if(ticketGrade == 1) {
	        	System.out.print("û�ҳ� ");
	        } else if(ticketGrade == 2) {
	        	System.out.print("��� ");
	        } else if(ticketGrade == 3) {
	        	System.out.print("���̺� ");
	        }
	        System.out.println("X " + ticketCount + "\t " + totalPrice + "��");
		}
        
        System.out.println("=========================================");
	}
}