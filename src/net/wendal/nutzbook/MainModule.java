package net.wendal.nutzbook;

import jetbrick.template.web.nutz.JetTemplateViewMaker;
import net.wendal.nutzbook.beetl.BeetlViewMaker2;

import org.nutz.integration.shiro.ShiroSessionProvider;
import org.nutz.mvc.annotation.ChainBy;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Localization;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SessionBy;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.annotation.Views;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

@SetupBy(value=MainSetup.class)
@IocBy(type=ComboIocProvider.class, args={"*js", "ioc/",
										   "*anno", "net.wendal.nutzbook",
										   "*tx",
										   "*org.nutz.integration.quartz.QuartzIocLoader",// 关联Quartz
										   "*org.snaker.nutz.SnakerIocLoader", /*"flows"*/ //关联snakerflow
										   "*org.nutz.integration.zbus.ZBusIocLoader", "net.wendal.nutzbook"
										   })
@Modules(scanPackage=true)
@ChainBy(args="mvc/nutzbook-mvc-chain.js")
@Ok("json:full")
@Fail("jsp:jsp.500")
@Localization(value="msg/", defaultLocalizationKey="zh-CN")
@Views({JetTemplateViewMaker.class, BeetlViewMaker2.class})
@SessionBy(ShiroSessionProvider.class)
public class MainModule {
}
