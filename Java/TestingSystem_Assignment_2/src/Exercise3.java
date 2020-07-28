import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class Exercise3 {

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
	//Question 1: In ra thông tin Exam thứ 1 và property create date sẽ được format Locale locale = new Locale("vi", "VN");
				
		Locale locale = new Locale("vi", "VN");
		DateFormat dateformat = DateFormat.getDateInstance(DateFormat.DEFAULT,locale);
		String date1 = dateformat.format(account1.createDate);
		System.out.println(exam1.code + " : " + date1);
				
	//Question 2: In ra thông tin: Exam đã tạo ngày nào theo định dạng :Năm – tháng – ngày – giờ – phút – giây
				String pattern2 = "yyyy-MM-dd-HH-mm-ss";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern2);

				Exam[] exams = { exam1, exam2 };				
				for (Exam exam : exams) {	
					String date2 = simpleDateFormat.format(exam.createDate);
					System.out.println(exam.code + ": " +date2);
	
				}
	//Question 3: Chỉ in ra năm của create date property trong Question 2
				String pattern3 = "yyyy";
				SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(pattern3);
				String	date3 = simpleDateFormat3.format(question2.createDate);
				System.out.println(date3);
					
	//Question 4: Chỉ in ra tháng và năm của create date property trong Question 2
					String pattern4 = "yyyy-MM";
					SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat(pattern4);
					String	date4 = simpleDateFormat4.format(question2.createDate);
					System.out.println(date4);
					
	// Question 5: Chỉ in ra "MM-DD" của create date trong Question 2
					String pattern = "DD-MM";
					SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat(pattern);
					String	date5 = simpleDateFormat5.format(question2.createDate);
					System.out.println(date5);
				}
}
