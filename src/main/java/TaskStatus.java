public enum TaskStatus {
    TO_DO("todo"),DONE("done");

    private String status;

    TaskStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
