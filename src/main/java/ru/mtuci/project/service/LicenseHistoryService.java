package ru.mtuci.project.service;

import ru.mtuci.project.models.ApplicationUser;
import ru.mtuci.project.models.License;
import ru.mtuci.project.models.LicenseHistory;
import ru.mtuci.project.requests.DataLicenseHistoryRequest;

import java.util.List;
import java.util.Optional;

public interface LicenseHistoryService {
    boolean recordLicenseChange(
            License license, ApplicationUser owner,
            String status, String description);
    Optional<LicenseHistory> findById(Long id);

    // save
    LicenseHistory save(DataLicenseHistoryRequest request);

    // read
    List<LicenseHistory> getAll();

    // update
    LicenseHistory update(DataLicenseHistoryRequest request);

    // delete
    void delete(Long id);
}

