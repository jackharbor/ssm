package mvc.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.mybatis.pojo.DocFile;
import mvc.mybatis.service.IDocFileService;
import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import utils.FileMD5;
import utils.SessionMap;

/**
 * @author PGIDWUY
 */

@Controller
@RequestMapping(value = "/wdzl")
public class WdzlController {
	
	@Autowired
	private IDocFileService service;
	
	
	
	@RequestMapping(value = "")
	public String toWdzlPage() {
		return "wdzl";
	}

	@RequestMapping(value = "method")
	@ResponseBody
	public JSONObject method(HttpServletRequest request) {
		String param=request.getParameter("param");
		//System.out.println(param);
		JSONObject josn=new JSONObject();
		josn.put("msg", "你好");
		return josn;
	}
	
	

	@RequestMapping(value = "upload")
	@ResponseBody
	public String upload(
			@RequestParam(value = "file") MultipartFile[] files,
			HttpServletRequest request) {
		String userid=request.getParameter("userid");
		
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				DocFile df=new DocFile();
				df.setUploader(userid);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				df.setUptime(sdf.format(new Date()));
				
				String realname=files[i].getOriginalFilename();
				df.setFilename(realname);
				
				String type = realname.substring(realname.indexOf("."));// 取文件格式后缀名
				String filename = System.currentTimeMillis() + type;// 取当前时间戳作为文件名
				
				String path = request.getSession().getServletContext().getRealPath("/upload/" + filename);// 存放位置
				
				df.setFilepath(path);
				
				service.addOne(df);
				
				File destFile = new File(path);
				try {
					if(!destFile.exists()) destFile.createNewFile();
					FileUtils.copyInputStreamToFile(files[i].getInputStream(),destFile);// 复制临时文件到指定目录下
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
				
				
			}

		}

		
		return "success";
	}
	
	
	@RequestMapping("download")    
    public ResponseEntity<byte[]> download() throws IOException {    
        String path="F:\\os\\Photoshop_CS6_CHS_Lite.exe";  
        File file=new File(path);  
        HttpHeaders headers = new HttpHeaders();    
        String fileName=new String("AccessibleMarshal.dll".getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
        headers.setContentDispositionFormData("attachment", fileName);   
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                                          headers, HttpStatus.OK);    
    }    
	
	@RequestMapping("download1")
	public void download1(HttpServletResponse response) throws IOException{
		String path="F:\\os\\Photoshop_CS6_CHS_Lite.exe";
		String fileName=new String("AccessibleMarshal.dll".getBytes("UTF-8"),"iso-8859-1");
		
		
		response.setHeader("content-disposition", "attachment;fileName="+fileName);
		InputStream in = new FileInputStream(path);
		OutputStream out = response.getOutputStream();
		
		
		byte buffer[] = new byte[1024];
		int len = 0;
		while ((len=in.read(buffer))>0) {
			out.write(buffer, 0, len);
		}
		in.close();
		out.close();
		
		
		
		
		/*
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		response.reset();
		response.setHeader("Content-disposition",
				"attachment; filename=" + fileName);
		response.setContentType("multipart/form-data");
		
		
		
		try {
	        //打开本地文件流
	        InputStream inputStream = new FileInputStream(path);
	        //激活下载操作
	        OutputStream os = response.getOutputStream();

	        //循环写入输出流
	        byte[] b = new byte[2048];
	        int length;
	        while ((length = inputStream.read(b)) > 0) {
	            os.write(b, 0, length);
	        }

	        // 这里主要关闭。
	        os.close();
	        inputStream.close();
	    } catch (Exception e){
	        e.printStackTrace();
	    }
		
		*/
		
	}
	
	
	

}
