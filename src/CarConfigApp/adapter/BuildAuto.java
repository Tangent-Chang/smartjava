package CarConfigApp.adapter;

import CarConfigApp.scale.IScalable;
import CarConfigApp.server.IAutoServer;

/**
 * Created by Tangent Chang on 6/20/15.
 */
public class BuildAuto extends ProxyAutomobile implements ICreateAuto, IUpdateAuto, IFixAuto, IScalable, IAutoServer {
}
