import java.util.Date;

public class Program {

	public static void main(String[] args) {
		// create department
		Department department1 = new Department();
		department1.departmentID = 1;
		department1.departmentName = "Sale";

		Department department2 = new Department();
		department2.departmentID = 2;
		department2.departmentName = "Marketting";
		
		Department department3 = new Department();
		department3.departmentID = 3;
		department3.departmentName = "Secretary";

		// Create position
		Position position1 = new Position();				
		position1.positionName = PositionName.DEV;
		position1.positionID = 1;

		Position position2 = new Position();				
		position2.positionName = PositionName.TEST;
		position2.positionID = 2;
		
		Position position3 = new Position();
		position3.positionName = PositionName.SCRUM_MASTER;
		position3.positionID = 3;
		// Create account
		Account account1 = new Account();
		account1.accountID = 1;
		account1.email = "account@gmail.com";
		account1.userName = "haidang";
		account1.fullName ="Nguyen Hai Dang";
		account1.position = position1;
		account1.department = department1;
		account1.createDate = new Date("2020/07/24");

		Account account2 = new Account();
		account2.accountID = 2;
		account2.email = "account1@gmail.com";
		account2.userName = "quanganh";
		account2.fullName ="Tong Quang Anh";
		account2.position = position1;
		account2.department = department1;
		account2.createDate = new Date("2020/07/24");

		Account account3 = new Account();
		account3.accountID = 3;
		account3.email = "account1@gmail.com";
		account3.userName = "quanganh";
		account3.fullName ="Tong Quang Anh";
		account3.position = position3;
		account3.department = department2;
		account3.createDate = new Date("2020/07/24");
		
		//// Create Group
		Group group1 = new Group();
		group1.groupID = 1;
		group1.groupName = "Testing System";
		group1.createDate =new Date("2020/07/24");
		
		Group group2 = new Group();
		group2.groupID = 2;
		group2.groupName = "Developement";
		group2.createDate = new Date("2020/07/24");
		
		Group group3 = new Group();
		group3.groupID = 3;
		group3.groupName = "Management";
		group3.createDate = new Date("2020/07/24");
		
		//Create GroupAccount
		
		GroupAccount groupAccount1 = new GroupAccount();
		groupAccount1.group = group3;
		groupAccount1.account = account1;
		groupAccount1.joinDate=new Date("2020/07/24");
		
		GroupAccount groupAccount2 = new GroupAccount();
		groupAccount2.group = group1;
		groupAccount2.account = account2;
		groupAccount2.joinDate=new Date("2020/07/24");
		
		GroupAccount groupAccount3 = new GroupAccount();
		groupAccount3.group = group3;
		groupAccount3.account = account3;
		groupAccount3.joinDate=new Date("2020/07/24");
		
		//Create TypeQuestion
		
		TypeQuestion typeQuestion1 = new TypeQuestion();
		typeQuestion1.typeID = 1;
		typeQuestion1.typeName = TypeName.ESSAY;
		
		TypeQuestion typeQuestion2 = new TypeQuestion();
		typeQuestion2.typeID = 2;
		typeQuestion2.typeName = TypeName.MULTIPLE_CHOICE;
		
		//Create CategoryQuestion
		
		CategoryQuestion categoryQuestion1 = new CategoryQuestion();
		categoryQuestion1.categoryID = 1;
		categoryQuestion1.categoryName = "Java";
		
		CategoryQuestion categoryQuestion2 = new CategoryQuestion();
		categoryQuestion2.categoryID = 2;
		categoryQuestion2.categoryName = "ASP.NET";
		
		CategoryQuestion categoryQuestion3 = new CategoryQuestion();
		categoryQuestion3.categoryID = 3;
		categoryQuestion3.categoryName = "SQL";
		
		// Create Question
		
		Question question1 = new Question();
		question1.questionID= 1;
		question1.content ="CÃ¢u há»�i vá»� Java";
		question1.categoryQuestion = categoryQuestion1;
		question1.typeQuestion = typeQuestion1;
		question1.account = account1;
		question1.createDate = new Date("2020/07/24");
		
		Question question2 = new Question();
		question2.questionID= 2;
		question2.content ="CÃ¢u há»�i vá»� SQL";
		question2.categoryQuestion = categoryQuestion1;
		question2.typeQuestion = typeQuestion2;
		question2.account = account3;
		question2.createDate = new Date("2020/07/24");
		
		Question question3 = new Question();
		question2.questionID= 3;
		question2.content ="CÃ¢u há»�i vá»� SQL";
		question2.categoryQuestion = categoryQuestion3;
		question2.typeQuestion = typeQuestion1;
		question2.account = account2;
		question2.createDate = new Date("2020/07/24");
		
		//Create Answer
		
		Answer answer2 = new Answer();
		answer2.answerID = 2;
		answer2.content = "Tráº£ lá»�i 02";
		answer2.question = question1;
		answer2.isCorrect = true;
		
		Answer answer1 = new Answer();
		answer1.answerID = 1;
		answer1.content = "Tráº£ lá»�i 01";
		answer1.question = question2;
		answer1.isCorrect = false;
		
		Answer answer3 = new Answer();
		answer3.answerID = 3;
		answer3.content = "Tráº£ lá»�i 03";
		answer3.question = question3;
		answer3.isCorrect = true;
		
		//Create Exam
		
		Exam exam1 = new Exam();
		exam1.EexamID = 1;
		exam1.code = "VTIQ001";
		exam1.title ="Ä�á»� thi C#";
		exam1.categoryID="Java";
		exam1.duration= 60;
		exam1.createDate=new Date("2020/07/24");
		
		Exam exam2 = new Exam();
		exam2.EexamID = 2;
		exam2.code = "VTIQ003";
		exam2.title ="Ä�á»� thi PHP";
		exam2.categoryID="PHP";
		exam2.duration= 120;
		exam2.createDate=new Date("2020/07/24");
		
		Exam exam3 = new Exam();
		exam3.EexamID = 3;
		exam3.code = "VTIQ003";
		exam3.title ="Ä�á»� thi SQL";
		exam3.categoryID="SQL";
		exam3.duration= 60;
		exam3.createDate=new Date("2020/07/24");
		
		// Create ExamQuestion
		ExamQuestion examQuestion1 = new ExamQuestion();
		examQuestion1.exam = exam2;
		Question[] questionOfExam1 = {question1,question2,question3};
		examQuestion1.question = questionOfExam1;
		
		// 
		
		Group[] groupOfAccount1 = {group1 , group2};
		account1.group = groupOfAccount1;

		Group[] groupOfAccount2 = {group3,group1};
		account2.group = groupOfAccount2;

		Group[] groupOfAccount3 = {group1,group2,group3};
		account3.group = groupOfAccount3;
		
		// Question1.
				if (account2.department == null) {
					System.out.println("Nhân viên này chưa có phòng ban");
				} else
					System.out.println("Phòng ban của nhân viên này là: "
							+ account2.department.departmentName);
		// Quetion2.
				if (groupOfAccount2 == null || groupOfAccount2.length == 0) 
				{
					System.out.println("Nhân viên này chưa có group");

				} else if (groupOfAccount2.length == 1) {
					System.out.println("Group của nhân viên này là :" + groupOfAccount2[0].groupName);

				} else if (groupOfAccount2.length == 2) {
					System.out.println("Group của nhân viên này là :" + groupOfAccount2[0].groupName + " , " + groupOfAccount2[1].groupName);

				} else if (groupOfAccount2.length == 3) {
					System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");

				} else
					System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
			
		//Question5
				Account[] accountOfGroup1 = { account1, account2, account3 };
				group1.account = accountOfGroup1;
				
				int x = group1.account.length;
				switch (x) {
				case 1:
					System.out.println("Nhóm có một thành viên");
					break;
				case 2:
					System.out.println("Nhóm có hai thành viên");
					break;
				case 3:
					System.out.println("Nhóm có ba thành viên");
					break;
				default:
					System.out.println("Nhóm có nhiều thành viên");
				}
				
			// Question 6: Sử dụng switch case để làm lại Question 2
				
				int y = account2.group.length;
				switch (y) {
				case 0:
					System.out.println("Nhân viên này chưa có group");
					break;
				case 1:
					System.out.println("Group của nhân viên này là"
							+ account2.group[0].groupName);
					break;
				case 2:
					System.out.println("Group của nhân viên này là : "
							+ account2.group[0].groupName + ", " + account2.group[1].groupName);
					break;
				case 3:
					System.out
							.println("Nhân viên này là người quan trọng, tham gia nhiều group !");
					break;
				default:
					System.out
							.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
				}
			//Question 8: in ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
				
				Account[] account = { account1, account2, account3 };
				for (Account accounts : account) {
					System.out.println("Email: " + accounts.email);
					System.out.println("FullName: " + accounts.fullName);
					System.out.println("Name Department: " + accounts.department.departmentName);
				}
			//Question 9: in ra thông tin các phòng ban bao gồm: id và name
				
				Department[] department = { department1, department2, department3 };
				for (Department departments : department) {
					System.out.println("ID Department: " + departments.departmentID);
					System.out.println("Name Department: " + departments.departmentName);
				}
			//Question 10: in ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
					//Thông tin account thứ 1 là:
					//Email: NguyenVanA@gmail.com
					//Full name: Nguyễn Văn A
					//Phòng ban: Sale
					//Thông tin account thứ 2 là:
					//Email: NguyenVanB@gmail.com
					//Full name: Nguyễn Văn B
					//Phòng ban: Marketting
				for (int i = 0; i < account.length; i++) 
				{
					System.out.println("Thông tin account thứ " + (i + 1) + " là :");
					System.out.println("Email: " + account[i].email);
					System.out.println("Fullname: " + account[i].fullName);
					System.out.println("Department: " + account[i].department.departmentName);
				}
			//in ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
					//Thông tin department thứ 1 là:
					//Id: 1
					//Name: Sale
					//Thông tin department thứ 2 là:
					//Id: 2
					//Name: Marketing
				for (int i = 0; i < department.length; i++) {
					System.out.println("Thông tin department thứ " + (i + 1) + " là :");
					System.out.println("ID: " + department[i].departmentID);
					System.out.println("Name: " + department[i].departmentName);
				}
				
			//Question 12: Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
				for (int i = 0; i < 2; i++) {
					System.out.println("Thông tin department thứ " + (i + 1) + " là :");
					System.out.println("ID: " + department[i].departmentID);
					System.out.println("Name: " + department[i].departmentName);
				}
			//Question 13: in ra thông tin tất cả các account ngoại trừ account thứ 2
				for (int i = 0; i < account.length; i++) 
				{
					if (i != 1) {
						System.out.println("Thông tin account thứ " + (i + 1)
								+ " là :");
						System.out.println("ID: " + account[i].accountID);
						System.out.println("Email: " + account[i].email);
						System.out.println("UserName: " + account[i].userName);
						System.out.println("FullName: " + account[i].fullName);
						System.out.println("Departmaent: " + account[i].department.departmentName);
						System.out.println("Position: " + account[i].position.positionName);
						System.out.println("CreateDate: " + account[i].createDate);
					}
				}
			// Question 14: in ra thông tin tất cả các account có id < 4
				for (int i = 0; i < account.length; i++) {
					if (account[i].accountID < 4) {
						System.out.println("Thông tin account thứ " + (i + 1) + " là :");
						System.out.println("Email: " + account[i].email);
						System.out.println("UserName: " + account[i].userName);
						System.out.println("Fullname: " + account[i].fullName);
						System.out.println("Department: " + account[i].department.departmentName);
						System.out.println("Position: " + account[i].position.positionName);
						System.out.println("CreateDate: " + account[i].createDate);
					}
				}
			//Question 15: in ra các số chẵn nhỏ hơn hoặc bằng 20
				for (int i = 2; i <= 20; i = i + 2) {
					System.out.println(i);
				}
			//Question 16: Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue
				//16-10
				int i = 0;
				while (i < account.length) {
					System.out.println("Thông tin account thứ " + (i + 1) + " là :");
					System.out.println("Email: " + account[i].email);
					System.out.println("UserName: " + account[i].userName);
					System.out.println("Fullname: " + account[i].fullName);
					System.out.println("Department: " + account[i].department.departmentName);
					System.out.println("Position: " + account[i].position.positionName);
					System.out.println("CreateDate: " + account[i].createDate);
					i++;
				}
				//16-11
				i = 0;
				while (i < department.length) {
					System.out.println("Thông tin department thứ " + (i + 1) + " là :");
					System.out.println("ID: " + department[i].departmentID);
					System.out.println("Name: " + department[i].departmentName);
					i++;
				}
				//16-12
				i = 0;
				while (i < 2) {
					System.out.println("Thông tin department thứ " + (i + 1) + " là :");
					System.out.println("ID: " + department[i].departmentID);
					System.out.println("Name: " + department[i].departmentName);
					i++;
				}
				//16-13
				i = 0;
				while (i < account.length) {

					if (i == 1) {
						i++;
						continue;
					}
					System.out.println("Thông tin account thứ " + (i + 1) + " là :");
					System.out.println("Email: " + account[i].email);
					System.out.println("UserName: " + account[i].userName);
					System.out.println("Fullname: " + account[i].fullName);
					System.out.println("Department: " + account[i].department.departmentName);
					System.out.println("Position: " + account[i].position.positionName);
					System.out.println("CreateDate: " + account[i].createDate);
					i++;
				}
				//16-14
				i = 0;
				while (i < account.length) {
					if (account[i].accountID >= 4) {
						i++;
						continue;
					}
					System.out.println("Thông tin account thứ " + (i + 1) + " là :");
					System.out.println("Email: " + account[i].email);
					System.out.println("UserName: " + account[i].userName);
					System.out.println("Fullname: " + account[i].fullName);
					System.out.println("Department: " + account[i].department.departmentName);
					System.out.println("Position: " + account[i].position.positionName);
					System.out.println("CreateDate: " + account[i].createDate);
					i++;
				}
				//16-15
				i = 2;
				while (i <= 20) {
					System.out.println(i);
					i = i + 2;
				}
				
	}
}
