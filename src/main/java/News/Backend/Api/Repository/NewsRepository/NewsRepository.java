package News.Backend.Api.Repository.NewsRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import News.Backend.Api.Model.News;

@Repository
public class NewsRepository implements NewsRepo {

	@Override
	public List<News> getNews() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<News> getNewsByCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<News> getNewsByKeyword() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
