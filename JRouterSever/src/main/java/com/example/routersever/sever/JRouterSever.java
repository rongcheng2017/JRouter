package com.example.routersever.sever;

import com.example.routersever.JRouter;
import com.example.routersever.sever.ISever.ISeverAdress;
import com.example.routersever.sever.ISever.ISeverAutowired;
import com.example.routersever.sever.ISever.ISeverFunction;
import com.example.routersever.sever.ISever.ISeverUi;
import com.example.routersever.sever.ISeverFactory.ISeverFactory;
import com.example.routersever.util.ExceptionUtil;

/**
 * Created by Canghaixiao.
 * Time : 2018/6/2 10:52.
 * Function :路由内部的sever端，负责为client端提供需要的功能
 */
public class JRouterSever implements ISeverFactory {

    static {
        if (!JRouter.isReady()) {
            ExceptionUtil.Runtime("you need to do JRouter.init(context) first");
        }
    }

    private static class Factory {
        private static JRouterSever mInstance = new JRouterSever();
    }

    public static ISeverFactory getFactory() {
        return Factory.mInstance;
    }

    @Override
    public ISeverFunction getFunctions() {
        return SeverFunctionImpl.getInstance();
    }

    @Override
    public ISeverUi getUIs() {
        return SeverUiImpl.getInstance();
    }

    @Override
    public ISeverAutowired getAutowireds() {
        return SeverAutowiredImpl.getInstance();
    }

    @Override
    public ISeverAdress getIps() {
        return SeverAdressImpl.getInstance();
    }

}
