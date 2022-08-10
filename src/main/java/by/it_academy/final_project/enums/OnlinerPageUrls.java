package by.it_academy.final_project.enums;

public enum OnlinerPageUrls{
    HOME_PAGE("https://www.onliner.by/");

    private String url;

    OnlinerPageUrls(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}