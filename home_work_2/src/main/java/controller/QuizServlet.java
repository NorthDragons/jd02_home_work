package by.it_academy.home_work2.controller;

import by.it_academy.home_work2.service.VoteService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;


/**
 * Данный класс выполняет роль контроллера
 */

@WebServlet(name = "QuizServlet", urlPatterns = "/")
public class QuizServlet extends HttpServlet {
    /**
     * создание экземпляра класса
     */
    private final VoteService service;

    public QuizServlet() {
        this.service = VoteService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String path = "/test/vote.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        /*
          req - получить что-то от браузера
         */
        String artist = req.getParameter("artist");
        String[] genres = req.getParameterValues("genre");
        String about = req.getParameter("about");

        //хз для чего
        this.service.addVote(artist, genres, about);

        Map<String, Integer> artistResult = this.service.getArtistResult();
        Map<String, Integer> genreResult = this.service.getGenreResult();
        List<String> aboutResult = this.service.getAboutResult();


        PrintWriter writer = resp.getWriter();
        /*
        Entry - Возвращает ключ из artistResult
         */
        for (Map.Entry<String, Integer> entry : artistResult.entrySet()) {
            switch (entry.getKey()) {
                case "1":
                    writer.write("Ирина Олегрова - ");
                    break;
                case "2":
                    writer.write("Каста - ");
                    break;
                case "3":
                    writer.write("Луна - ");
                    break;
                case "4":
                    writer.write("Иванушки - ");
                    break;
            }
            writer.write(String.valueOf(entry.getValue()));
        }

        writer.write("<br/><b>Лучшие жанры</b><br/>");

        for (Map.Entry<String, Integer> entry2 : genreResult.entrySet()) {

            switch (entry2.getKey()) {
                case "1":
                    writer.write("Рок - ");
                    break;
                case "2":
                    writer.write("Поп - ");
                    break;
                case "3":
                    writer.write("Фолк - ");
                    break;
                case "4":
                    writer.write("Альт - ");
                    break;
                case "5":
                    writer.write("Клкассика - ");
                    break;
                case "6":
                    writer.write("Джаз - ");
                    break;
                case "7":
                    writer.write("Тиктоник - ");
                    break;
            }

            writer.write(String.valueOf(entry2.getValue()));
            writer.write("<br/>");

        }
        System.out.println(aboutResult);
        writer.write(String.valueOf(aboutResult));
    }
}
