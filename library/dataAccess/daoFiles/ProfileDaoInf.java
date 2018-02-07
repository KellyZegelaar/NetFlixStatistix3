package library.dataAccess.daoFiles;

import library.domain.Profile;

import java.util.ArrayList;

public interface ProfileDaoInf {
    ArrayList<Profile> readProfiles();
}
