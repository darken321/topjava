package ru.javawebinar.topjava.web.user;

/** Зачем в AdminRestController переопределяются методы родителя с вызовом тех же родительских?
 * Сделано на будущее, мы будем менять этот код.
 */

import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.User;

import java.util.List;

@Controller
public class AdminRestController extends AbstractUserController {

    @Override
    public List<User> getAll() {
        return super.getAll();
    }

    @Override
    public User get(int id) {
        return super.get(id);
    }

    @Override
    public User create(User user) {
        return super.create(user);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }

    @Override
    public void update(User user, int id) {
        super.update(user, id);
    }

    @Override
    public User getByMail(String email) {
        return super.getByMail(email);
    }
}