var eui = {
	/**
	 * easyui样式弹窗
	 * @param msg
	 * @param options.icon(error,question,info,warning)
	 */
	alert : function(msg, options) {
		var defTitle = '提示';
		var defIcon = 'info';
		if(options){
			if(options.title){
				defTitle = options.title;
			}
			if(options.icon){
				defIcon = options.icon;
			}
			if(options.func){
				$.messager.alert(defTitle, msg, defIcon,options.func);
			}else{
				$.messager.alert(defTitle, msg, defIcon);
			}
		}else{
			$.messager.alert(defTitle, msg, defIcon);
		}
		
	},
	
	/**
	 * 自定义确认弹窗
	 * @param title
	 * @param msg
	 * @param okFunc
	 * @param cancelFunc
	 */
	confirm : function(title,msg,okFunc,cancelFunc) {
		$.messager.confirm(title, msg, function(r) {
			if (r) {
				okFunc.call();
			} else {
				if(cancelFunc){
					cancelFunc.call();
				}
			}
		});
	},
	
	/**
	 * easyui样式输入值弹窗
	 * @param title
	 * @param msg
	 * @param okFunc
	 * @param cancelFunc
	 */
	prompt: function(title,msg,okFunc,cancelFunc){
		$.messager.prompt(title, msg, function(r){
			if (r){
				okFunc.call(okFunc,r);
			} else {
				if(cancelFunc){
					cancelFunc.call();
				}
			}
		});
	},
	
	/**
	 * 在屏幕右下角显示一条消息窗口。
	 * @param options.showType：定义将如何显示该消息。可用值有：null,slide,fade,show。默认：slide。
	 * @param options.showSpeed：定义窗口显示的过度时间。默认：600毫秒。
	 * @param options.width：定义消息窗口的宽度。默认：250px。
	 * @param options.height：定义消息窗口的高度。默认：100px。
	 * @param options.style：定义消息窗体的自定义样式。
	 * @param options.timeout：如果定义为0，消息窗体将不会自动关闭，除非用户关闭他。如果定义成非0的树，消息窗体将在超时后自动关闭。默认：4秒。 
	 * 
	 * 
	 */
	show: function(title,msg,options){
		if(!options){
			options={};
		}
		options.title=title;
		options.msg=msg;
		$.messager.show(options);
	}
	
	
	
};