package guru.springframewrok.spring5webapp.bootstrap;

import guru.springframewrok.spring5webapp.model.Author;
import guru.springframewrok.spring5webapp.model.Book;
import guru.springframewrok.spring5webapp.model.Publisher;
import guru.springframewrok.spring5webapp.repositories.AuthorRepository;
import guru.springframewrok.spring5webapp.repositories.BookRepository;
import guru.springframewrok.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("foo");

        publisherRepository.save(publisher);

        // Jack
        Author jack = new Author("Jack", "Tran");
        Book ddd = new Book("Domain Driven Design","1234",publisher);
        jack.getBooks().add(ddd);
        ddd.getAuthors().add(jack);

        authorRepository.save(jack);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB","2344",publisher);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
