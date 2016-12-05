package net.wendal.nutzbook.plugin;

import java.util.Iterator;

import org.nutz.aop.InterceptorChain;

/**
 * 代理原本的
 * @author wendal
 *
 */
public class InterceptorChainProxy extends InterceptorChain {
    
    protected Iterator<IPlugin> it;
    protected InterceptorChain chain;

    public InterceptorChainProxy(InterceptorChain chain,
                                 Iterator<IPlugin> it) {
        super(0, chain.getCallingObj(), chain.getCallingMethod(), chain.getMethodInterceptors(), chain.getArgs());
        this.it = it;
        this.chain = chain;
    }

    public InterceptorChain doChain() throws Throwable {
        if (it.hasNext())
            it.next().filter(this);
        return chain.doChain();
    }
    
    // TODO 代理其他方法
}