package News.Backend.Api.Repository.NewsRepository;

import java.util.List;

import News.Backend.Api.Model.News;

public interface NewsRepo {
	public List<News> getNews();
	public List<News> getNewsByCategory();
	public List<News> getNewsByKeyword();
}
