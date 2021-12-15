public class Task {
    private Integer id;
    private String desc;
    private TaskStatus status;

    public Task() {
    }

    public Task(Integer id, String desc, TaskStatus status) {
        this.id = id;
        this.desc = desc;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
