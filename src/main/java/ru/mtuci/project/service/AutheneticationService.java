package ru.mtuci.project.service;

import ru.mtuci.project.models.ApplicationUser;

public interface AutheneticationService {
    boolean authenticate(ApplicationUser user, String password);
}
