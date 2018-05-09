package forbeatdev.userrestapi.util;

/**Using this for change user status*/
public enum UserStatus {
    Online,
    Offline;

    public UserStatus getAnother(){
            if (this == UserStatus.Offline) {
                return Online;
            } else
                return Offline;

    }
}
