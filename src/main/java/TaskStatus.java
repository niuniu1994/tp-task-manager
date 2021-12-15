public enum TaskStatus {
    TO_DO(" "),DONE("x");

    private String status;

    TaskStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
