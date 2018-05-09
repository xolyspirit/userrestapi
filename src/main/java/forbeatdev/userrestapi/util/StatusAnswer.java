package forbeatdev.userrestapi.util;

/**Using this for wrap user information in a comfort appearance */
public class StatusAnswer {
    private Long id;
    private UserStatus newStatus;
    private UserStatus oldStatus;
    private String success;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(UserStatus newStatus) {
        this.newStatus = newStatus;
    }

    public UserStatus getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(UserStatus oldStatus) {
        this.oldStatus = oldStatus;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
