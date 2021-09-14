package by.it_academy.storage.api;

import by.it_academy.model.Employer;

public interface IEmployerStorage {
    void putEmployer(Employer employer);
    Employer getEmployer(Long id);

}
