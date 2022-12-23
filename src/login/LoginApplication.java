package login;

import java.util.Scanner;

public class LoginApplication {
    private static Scanner sc = new Scanner(System.in);
    private static User[] loginArray = new User[10];
    private static User[] obj = new User[10];
    private static int userCount = 0;


    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 10; i++) {
            loginArray[i] = new User();
            obj[i] = new User();
        }

        boolean run = true;

        while (run) {
            System.out.println("---------------가입된 사용자 : " + userCount + "명---------------");
            System.out.println("1.회원가입 | 2.로그인 | 3.사용자조회 | 4.탈퇴 | 5.종료");
            System.out.println("-----------------------------------------------------------------");

            System.out.println("선택 >");
            int Number = sc.nextInt();

            if (Number == 1) {
                signUp(userCount);

            } else if (Number == 2) {
                login();
            } else if (Number == 3) {
                userList();
            } else if (Number == 4) {
                deleteUser();
            } else if (Number == 5) {
                System.out.println("프로그램 종료");
                run = false;
            } else {
                System.out.println("올바른 숫자를 입력해주세요. >");
            }
        }
    }

    public static void signUp(int usercount) throws Exception {
        try {

            if (usercount < 10) {
                System.out.println("-----------------------------------------------------------------");
                System.out.println("회원가입");
                System.out.println("-----------------------------------------------------------------");

                System.out.print("ID: ");
                String id = sc.next();

                System.out.print("PASSWORD: ");
                String password = sc.next();

                System.out.print("NICKNAME: ");
                String name = sc.next();

                if (check(id)) {
                    System.out.println("ID가 중복입니다.");
                    return;
                }
                loginArray[usercount] = new User(id, password, name);
                System.out.println("회원가입이 완료되었습니다.");
                userCount++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("가입할 수 있는 인원을 초과했습니다.");
        }
    }

    private static boolean check(String id) {
        for (User check : loginArray) {
            if (check.getId() != null && check.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private static void login() {
        System.out.println("-------------");
        System.out.println("로그인");
        System.out.println("-------------");

        System.out.print("ID: ");
        String loginId = sc.next();

        System.out.print("PASSWORD: ");
        String loginPassword = sc.next();


        for (User login : loginArray) {
            if (login.getId().equals(loginId) && login.getPassword().equals(loginPassword)) {
                System.out.println(loginId + "\t" + loginPassword);
                break;
            } else
                System.out.println("로그인에 실패하였습니다.");
        }

    }

    private static void userList() {
        System.out.println("-------------");
        System.out.println("사용자 조회");
        System.out.println("-------------");

        for (User obj : loginArray) {
            if (obj.getName() != null) {
                System.out.println(obj.getName());
            }
        }
    }
/*
for (int i=0;i<length;i++)*/
    private static void deleteUser() {
        System.out.print("ID: ");
        String loginId = sc.next();

        System.out.print("PASSWORD: ");
        String loginPassword = sc.next();

        for (int i = 0; i < loginArray.length; i++) {
            if (loginArray[i].getId().equals(loginId) && loginArray[i].getPassword().equals(loginPassword)) {
                int num = i;
                // 0번에 1이라는 아이디 삭제하면 null
                loginArray[i]=null;
                while(loginArray[num]==null) {
                    loginArray[i] = loginArray[i + 1];
                    loginArray[i+1]=null;
                    num++;
                }

                System.out.println("탈퇴에 성공하였습니다.");
                loginArray[i].setId(null);
                loginArray[i].setPassword(null);
                loginArray[i].setName(null);
                userCount--;
                break;
            } else
                System.out.println("탈퇴에 실패하였습니다.");
        }
    }
}
