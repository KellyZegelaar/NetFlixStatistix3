package library.applicationLogic;

import library.dataAccess.ProfileDao;
import library.domain.Profile;

import java.util.ArrayList;

public class ProfileManager {
    private ArrayList<Profile> profiles;

    public ProfileManager() {
        profiles = new ArrayList<>();
    }
}
