package mvc.mybatis.service;

import java.util.List;
import mvc.mybatis.pojo.DocFile;

public interface IDocFileService {

	public List<DocFile> getDocFileList(DocFile file);
	
	public void addOne(DocFile file);
}