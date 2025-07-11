package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRepositoryImpl {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> example() {
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is("Ram"));
        // we can add many criteria.
        query.addCriteria(Criteria.where("password").ne(null)); // ne = not equal
        return mongoTemplate.find(query, User.class);
    }

    public List<User> getUserForSA() {
        Query query = new Query();
        // we can add many criteria.
        Criteria criteria = new Criteria();
        query.addCriteria(criteria.andOperator(
                Criteria.where("email").regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"),
                Criteria.where("sentimentAnalysis").is(true))
        );
        //query.addCriteria(Criteria.where("roles").in("USER", "ADMIN"));
        return mongoTemplate.find(query, User.class);
    }
    public User findByUserName(String userName)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(userName));
        User users = mongoTemplate.findOne(query, User.class);
        return users;
    }


}
