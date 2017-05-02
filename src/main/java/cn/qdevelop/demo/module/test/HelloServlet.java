package cn.qdevelop.demo.module.test;

import java.util.Map;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import cn.qdevelop.service.APIControl;
import cn.qdevelop.service.IOutput;
import cn.qdevelop.service.IService;

@WebServlet(
		//自定义接口URI，前端可直接访问；注意系统内不可重复，否则会启动报错
		urlPatterns="/moudle/demo/hello",
		loadOnStartup=1,initParams={
				//value内填写需要验证必须存在的参数，其他参数将自动按数据库内的格式自动校验,可将绝大部分数据验证自动处理了
				@WebInitParam(name=IService.INIT_VALID_REQUIRED,value="wd"),
				//value内填写忽略验证的参数，有些特殊参数可能会被误拦截为可疑hack字符
				@WebInitParam(name=IService.INIT_VALID_IGNORE,value="")
		})
public class HelloServlet extends APIControl{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7031030573058419645L;

	@Override
	public void init(Map<String, String> args) {
		
	}

	@Override
	protected String execute(Map<String, String> args, IOutput output) {
		String wd = args.get("wd");
		output.setData(new StringBuffer().append(System.currentTimeMillis()).append(":").append(wd));
		return null;
	}

}
