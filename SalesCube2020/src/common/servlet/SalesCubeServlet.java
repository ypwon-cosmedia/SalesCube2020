package common.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import common.controller.BaseController;
import common.controller.CreateControllers;


import java.util.*;
import java.sql.SQLException;

import user.DAO.*;
import user.beans.*;
import user.controller.*;

public class SalesCubeServlet extends HttpServlet {


	private HashMap<String, BaseController> controllerList;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
        String  forwardURL;

        String action = request.getParameter("action");

        // �Ɩ��̐U�蕪��
        if  ( controllerList.containsKey(action) )  {							// action�ɊY������Ɩ��R���g���[��������ꍇ

        	BaseController controller = controllerList.get(action);			//   �Y������Ɩ��R���g���[�����擾
            forwardURL = controller.execService(request, response);				//   �Ɩ��R���g���[���ɏ������Ϗ����t�H���[�h����JSP��URL���擾����
            RequestDispatcher rd = request.getRequestDispatcher(forwardURL);	//   �f�B�X�p�b�`���[���擾
            rd.forward(request, response);										//   �o�͏�����JSP�ɈϏ��i�t�H���[�h�j

        } else {

            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");	// action�p�����^�l��������Ȃ��ꍇ�͑J�ڃG���[�y�[�W��\��
            rd.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

	public void init() throws ServletException {
    
		
		controllerList = new CreateControllers().newControllers();
    }
}
