package mvc.mybatis.dao;

import java.util.List;
import mvc.mybatis.pojo.DocFile;


public interface DocFileDao {

	public List<DocFile> docfilelist(DocFile file);
	
	public void add(DocFile file);
}
