package main.java.org.example;

import main.java.org.example.article.ArticleController;
import main.java.org.example.system.SystemController;

public class App {
    ArticleController articleController;
    SystemController systemController;

    App() {
        articleController = new ArticleController();
        systemController = new SystemController();
    }
    public void run() {
        System.out.print("명령) ");
        String command = Container.getSc().nextLine().trim();
        Request request = new Request(command);
        while (true) {
            if (request.getActionCode().equals("종료")) {
                systemController.exit();
                break;
            } else if (request.getActionCode().equals("등록")) {
                articleController.write();
                run();
                return;
            } else if (request.getActionCode().equals("목록")) {
                articleController.list();
                run();
                return;
            } else if (request.getActionCode().startsWith("삭제")) {
                articleController.delete(request);
                run();
                return;
            } else if (request.getActionCode().startsWith("수정")) {
                articleController.modify(request);
                run();
                return;
            }
        }
    }
}