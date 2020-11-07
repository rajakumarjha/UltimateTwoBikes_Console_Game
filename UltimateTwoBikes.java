package UltimateTwoBikes;

import java.util.Random;
import java.util.Scanner;



public class UltimateTwoBikes {
	public static class Node{
		int number;
		int val;
		int Road;
		char c='*';
		Node second=null;
		Node Random=null;
		Node next=null;
		public Node(int val){
			this.val=val;
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random random=new Random();
		System.out.println("Welcome to Ultimate TWo Bike Game: ");
		System.out.println("Rules for the game: ");
		System.out.println("You can either move: forward or right/left depending on road you are in.");
		System.out.println("1. Forward pres 5");
		System.out.println("2. right/left press 3");
		System.out.println("3. Jump over to next if bridge is there ");
		
		System.out.println();
		System.out.println("(0,0) first zero:"+"0-> No stone, 1-> stone");
		System.out.println("(0,0) second zero:"+"0-> Bridge, 1-> No Bridge");
		System.out.println();
		System.out.println("Name first player: ");
		String player1=sc.next();
		System.out.println(player1+" Choose your Bike: ");
		System.out.println("Enter 1:for Ferrari");
		System.out.println("Enter 2:for KTM");
		System.out.println("Enter 3:for R15");
		int bike=sc.nextInt();
		String player1Bike;
		if(bike==1){
			player1Bike="Ferrari";
			System.out.println(player1+" you choose "+player1Bike);
		}else if (bike==2){
			player1Bike="KTM";
			System.out.println(player1+" you choose "+player1Bike);
		}else{
			player1Bike="R15";
			System.out.println(player1+" you choose "+player1Bike);
		}
		Node bike1=new Node(0);
		bike1.number=1;
		bike1.Road=1;
		System.out.println("Name Second player: ");
		String player2=sc.next();
		System.out.println(player2+" Choose your Bike: ");
		System.out.println("Enter 1: for Ferrari");
		System.out.println("Enter 2:for KTM");
		System.out.println("Enter 3: for R15");
		bike=sc.nextInt();
		String player2Bike;
		if(bike==1){
			player2Bike="Ferrari";
			System.out.println(player2+" you choose "+player2Bike);
		}else if(bike==2){
			player2Bike="KTM";
			System.out.println(player2+" you choose "+player2Bike);
		}else{
			player2Bike="R15";
			System.out.println(player2+" you choose "+player2Bike);
		}
		Node bike2=new Node(0);
		bike2.number=1;
		bike2.Road=2;
		Node temp1=bike1;
		Node temp2=bike2;
		System.out.println("Wait...Road is being created!!");
		Boolean flag=random.nextBoolean();
		for(int i=2;i<20;i++){
			Node nextNode1,prevNode1=bike1;
			Node nextNode2,prevNode2=bike2;
			if(flag==true){
				nextNode1=new Node(1);
				nextNode2=new Node(0);
				flag=false;
			}else{
				nextNode1=new Node(0);
				nextNode2=new Node(1);
				flag=true;
			}
			Node remp1=bike1;
			Node remp2=bike2;
           int rand1=random.nextInt(i);
           while(rand1>1){
        	   rand1--;
        	   remp1=remp1.next;
           }
           if(remp1.val==1){remp1.val=0;}
           rand1=random.nextInt(i);
           while(rand1>1){
        	   rand1--;
        	   remp2=remp2.next;
           }
           if(remp2.val==1){remp2.val=0;}
			
			nextNode1.number=i;
			nextNode1.Road=1;
			nextNode2.number=i;
			nextNode2.Road=2;
			temp1.next=nextNode1;
			temp1=temp1.next;
			temp2.next=nextNode2;
			temp2=temp2.next;
			prevNode1=nextNode1;
			prevNode2=nextNode2;
			
		}
		
		System.out.println("Wait...Linking Road1 and Road2");
		temp1=bike1;
		temp2=bike2;
		while(temp1!=null){
			temp1.second=temp2.next;
			temp2.second=temp1.next;
			temp1=temp1.next;
			temp2=temp2.next;
		}
		//linking is over
		
		System.out.println("Wait... creating bridges ");
		temp1=bike1.next;
		temp2=bike2.next;
		int count1=0;
		int count2=0;
		int counter=0;
		while(temp1!=null&&temp2!=null&&temp1.next!=null&&temp2.next!=null&&temp1.next.next!=null&&counter<20&&temp1.next.next!=null){
			counter++;
			if(temp1.val==0&&temp1.next.next!=null&&temp1.next.next.val==0&&count1<5){
				temp1.Random=temp1.next.next;
				count1++;
				temp1=temp1.Random;
			}
			if(temp2.val==0&&temp2.next.next!=null&&temp2.next.next.val==0&&count2<5){
				temp2.Random=temp2.next.next;
				count2++;
				temp2=temp2.Random;
			}
			if(count1>=3&&count2>=3){break;}
			int rand=random.nextInt(5);
			while(rand>0){
				rand--;
				if(temp1.next!=null){
					temp1=temp1.next;
				}
				
				
			}
			rand=random.nextInt(5);
			while(rand>0){
				rand--;
				if(temp2!=null){
					temp2=temp2.next;
				}
				
				
			}
		}
		System.out.println("Successfully created Road!!");
		System.out.println();
		
		char player1char=player1.charAt(0);
		char player2char=player2.charAt(0);
		temp1=bike1;
		temp1.c=player1char;
		bike2.Road=2;
		temp2=bike2;
		temp2.c=player2char;
		System.out.println(player1+" you are at "+temp1.number+" in Road number "+temp1.Road);
		while(temp1!=null&&temp2!=null){
			if(temp1.next==null){
				System.out.println("Congratulations "+player1+ " you won the game!!");
				break;
			}
			if(temp2.next==null){
				System.out.println("Congratulations "+player2+ " you won the game!!");
				break;
			}
			System.out.println();
			System.out.println("Road Map:");
			Node tempView1=bike1;
			Node tempView2=bike2;
			int count10=0;
	
			System.out.print("Road 1->");
			while(tempView1!=null){
				int r=1;
				if(tempView1.Random!=null){r=0;}
				System.out.print(tempView1.number+"."+"("+tempView1.val+","+r+","+tempView1.c+","+")"+":::");
				count10++;
				tempView1=tempView1.next;
			}
			System.out.println();
			count10=0;
			System.out.print("Road 2->");
			while(tempView2!=null){
				int r=1;
				if(tempView2.Random!=null){r=0;}
				System.out.print(tempView2.number+"."+"("+tempView2.val+","+r+","+tempView2.c+","+")"+":::");
				count10++;
				tempView2=tempView2.next;
			}
			
			System.out.println();
			System.out.println(player1+" , "+player2+" is at "+temp2.number+" in Road number "+ temp2.Road);
			System.out.println(player1+ " you are at "+temp1.number+ " in Road number "+temp1.Road);
			System.out.println();
			System.out.println(player1+ " Enter one of following number to move: ");
			System.out.println("Enter 5 : move forward ");
			System.out.println("Enter 1 : Jump Over next ");
			System.out.println("Enter 3 : jump to right ");
			System.out.println("Enter 2 : to stay ");
			int command1=sc.nextInt();
			if(command1==5){
				if(temp1.next.val==0&&temp2!=temp1.next){
					temp1.c='*';
					temp1=temp1.next;
					temp1.c=player1char;
					System.out.println(player1+" you are at: "+temp1.number+" in Road Number: "+temp1.Road);
				}else{
					System.out.println(player1+"You Loss!!");
					break;
				}
			}else if(command1==1){
				if(temp1.Random!=null&&temp2!=temp1.Random){
					temp1.c='*';
					temp1=temp1.Random;
					temp1.c=player1char;
					System.out.println(player1+" you are at: "+temp1.number+" in Road Number: "+temp1.Road);
				}else{
					System.out.println(player1+"You Loss!!");
					break;
				}
			}else if(command1==3){
				if(temp2!=temp1.second&&temp1.second.val==0){
					temp1.c='*';
					temp1=temp1.second;
					temp1.c=player1char;
					System.out.println(player1+" you are at: "+temp1.number+" in Road Number: "+temp1.Road);
				}else{
					System.out.println(player1+"You Loss!!");
					break;
				}
			}else{
				System.out.println(player1+" you are at: "+temp1.number+" in Road Number: "+temp1.Road);
			}
			System.out.println();
			System.out.println("Road Map:");
			tempView1=bike1;
			tempView2=bike2;
			count10=0;
			System.out.println();
			System.out.print("Road 1->");
			while(tempView1!=null){
				int r=1;
				if(tempView1.Random!=null){r=0;}
				System.out.print(tempView1.number+"."+"("+tempView1.val+","+r+","+tempView1.c+","+")"+":::");
				count10++;
				tempView1=tempView1.next;
			}
			System.out.println();
			count10=0;
			System.out.print("Road 2->");
			while(tempView2!=null){
				int r=1;
				if(tempView2.Random!=null){r=0;}
				System.out.print(tempView2.number+"."+"("+tempView2.val+","+r+","+tempView2.c+","+")"+":::");
				count10++;
				tempView2=tempView2.next;
			}
			System.out.println();
			System.out.println();
			System.out.println(player2+" , "+player1+" is at "+temp1.number+" in Road number "+ temp1.Road);
			System.out.println(player2+" you are at: "+temp2.number+" in Road Number: "+temp2.Road);
			System.out.println(player2+ " Enter one of following number to move: ");
			System.out.println("Enter 5 : move forward ");
			System.out.println("Enter 1 : Jump Over next ");
			System.out.println("Enter 3 : jump to right ");
			System.out.println("Enter 2 : to stay ");
			 command1=sc.nextInt();
			if(command1==5){
				if(temp2.next.val==0&&temp2.next!=temp1){
					temp2.c='*';
					temp2=temp2.next;
					temp2.c=player2char;
					System.out.println(player2+" you are at: "+temp2.number+" in Road Number: "+temp2.Road);
				}else{
					System.out.println(player2+"You Loss!!");
					break;
				}
			}else if(command1==1){
				if(temp2.Random!=null&&temp2.Random!=temp1){
					temp1.c='*';
					temp2=temp2.Random;
					temp2.c=player2char;
					System.out.println(player2+" you are at: "+temp2.number+" in Road Number: "+temp2.Road);
				}else{
					System.out.println(player2+"You Loss!!");
					break;
				}
			}else if(command1==3){
				if(temp1!=temp2.second&&temp2.second.val==0){
					temp2.c='*';
					temp2=temp2.second;
					temp2.c=player2char;
					System.out.println(player2+" you are at: "+temp2.number+" in Road Number: "+temp2.Road);
				}else{
					System.out.println(player2+" You Loss!!");
					break;
				}
			}else{
				System.out.println(player1+" you are at: "+temp2.number+" in Road Number: "+temp2.Road);
			}
			if((temp1!=null&&temp1.next!=null&&temp1.next.val==1&&temp1.second.val==1&&temp1.Random==null)){
				System.out.println(player1+" Your Road is blocked !! You Lose");
				break;
			}
			if((temp2!=null&&temp2.next!=null&&temp2.next.val==1&&temp2.second.val==1&&temp2.Random==null)){
				System.out.println(player2+" Your Road is blocked !! You Lose");
				break;
			}
			if(temp1!=null&&temp1.next==null){
				System.out.println("Congratulations "+player1+ " you won the game!!");
				break;
			}
			if(temp2!=null&&temp2.next==null){
				System.out.println("Congratulations "+player2+ " you won the game!!");
				break;
			}
		
		}
		
		
	}

}
