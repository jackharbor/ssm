package mvc.mybatis.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mvc.mybatis.dao.DocFileDao;
import mvc.mybatis.pojo.DocFile;
import mvc.mybatis.service.IDocFileService;


@Service()
public class DocFileService implements IDocFileService {

	@Autowired
	private DocFileDao dao;

	@Override
	public List<DocFile> getDocFileList(DocFile file) {
		return dao.docfilelist(file);
	}

	@Override
	public void addOne(DocFile file) {
		dao.add(file);
	}
	


}
