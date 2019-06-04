package com.newlecture.web.controller.admin.notice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ProcessBuilder.Redirect;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;import org.eclipse.jdt.internal.compiler.util.SuffixConstants;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.oracle.OracleNoticeDao;
import com.newlecture.web.dao.oracle.OracleNoticeFileDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeFile;

@WebServlet("/admin/notice/reg")

@MultipartConfig(location = "D:\\download", 
		fileSizeThreshold = 1024 * 1024, 
		maxFileSize = 1024 * 1024 * 5, // 5�ް�
		maxRequestSize = 1024 * 1024 * 5 * 5 // 5�ް� 5������
)

public class RegController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Part filePart = request.getPart("file");
		
		
		// 1.
		String urlPath = "/upload";
		String path = request
				.getServletContext()
				.getRealPath(urlPath);
		
		System.out.println(path);
		
		String fileName = filePart.getSubmittedFileName();
		
		// 3. ��� ������ �ֱ�
		String filePath = path +File.separator+ fileName;
		
		System.out.println(filePath);
		
		// 4. ��ΰ� ���ٴ� ���� ����
		File pathFile = new File(path);
		if(!pathFile.exists())
			pathFile.mkdirs();
		

		// 5. ������ ���ϸ� ��ο� �̹� �����ϴ� ���� : �̸� ��å
		//aa.jpg -> aa.jpg1 ==> aa1.jpg
		//aa1.jpg -> aa(1).jpg
		
		
		

		

		
		/* File ? = new File(?);
		  if(? �����Ѵٸ�){
		  	����(Ȯ����)�� �߶� �̸��� ���
		  	�� �������� �Ұ�ȣ()�� �ִ��� Ȯ���ϰ�
		  	������ ��ȣ�� �˾Ƴ��� 1������ ������ ��...
		  	fileName = ?;
		  }
		  */
		File sameFile = new File(filePath);
		
		if(sameFile.exists()) {
			
			int n = fileName.lastIndexOf("."); //fileName=hello.jpg   n=13, name =hello, suffix= .jpg
			
			String name = fileName.substring(0, n); // hello
			String suffix = fileName.substring(n); // .jpg
			
			int parenS = fileName.lastIndexOf("("); 
			int parenE = fileName.lastIndexOf(")");
			
						
			if (parenS == -1) {
				fileName = name +"("+ 1 +")"+ suffix;

			}
			else {
				String indexC = name.substring(parenS+1, parenE); //
				
				int indexN = Integer.parseInt(indexC);
				indexN++;
				fileName = name +"("+ indexN +")"+ suffix;
			}
		}
		
		
		InputStream fis = filePart.getInputStream();
		OutputStream fos = new FileOutputStream(filePath);
		
		byte[] buf = new byte[1024];

		int size = 0;

		while ((size = fis.read(buf)) != -1) {
			fos.write(buf, 0, size);
		}
		
		fis.close();
		fos.close();
		
		System.out.println("���� �Ϸ�");

		System.out.println(title);

		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);

		NoticeDao noticeDao = new OracleNoticeDao();
		NoticeFileDao noticeFileDao = new OracleNoticeFileDao();
		
		int result = 0;

		try {
			result = noticeDao.insert(notice);
			int noticeId = noticeDao.getLastId();
			
			NoticeFile noticeFile = new NoticeFile();
			//noticeFile.setId(?);
			noticeFile.setName(fileName);
			noticeFile.setNoticeId(noticeId);
			
			noticeFileDao.insert(noticeFile);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		  if(result != 1) response.sendRedirect("error"); else
		  response.sendRedirect("list");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/notice/reg.jsp").forward(request, response);
	}

}
