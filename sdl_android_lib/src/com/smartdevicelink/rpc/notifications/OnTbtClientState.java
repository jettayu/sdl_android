package com.smartdevicelink.rpc.notifications;

import java.util.Hashtable;

import com.smartdevicelink.protocol.enums.FunctionId;
import com.smartdevicelink.proxy.RpcNotification;
import com.smartdevicelink.rpc.enums.TbtState;

/**
 * <p>Notifies the application of the current TBT client status on the module.</p>
 *
 * <p></p>
 * <b>HMI Status Requirements:</b>
 * <ul>
 * HMILevel: 
 * <ul><li>Can be sent with FULL, LIMITED or BACKGROUND</li></ul>
 * AudioStreamingState: 
 * <ul><li>Any</li></ul>
 * SystemContext: 
 * <ul><li>Any</li></ul>
 * </ul>
 * <p></p>
 * <b>Parameter List:</b>
 * <table  border="1" rules="all">
 * <tr>
 * <th>Name</th>
 * <th>Type</th>
 * <th>Description</th>
 * <th>SmartDeviceLink Ver Available</th>
 * </tr>
 * <tr>
 * <td>state</td>
 * <td>{@linkplain TbtState}</td>
 * <td>Current state of TBT client.</td>
 * <td>SmartDeviceLink 1.0</td>
 * </tr>
 * </table>
 * @since SmartDeviceLink 1.0
 * 
 */
public class OnTbtClientState extends RpcNotification {
	public static final String KEY_STATE = "state";
	/**
	*Constructs a newly allocated OnTBTClientState object
	*/ 
    public OnTbtClientState() {
        super(FunctionId.ON_TBT_CLIENT_STATE.toString());
    }
    /**
     *<p>Constructs a newly allocated OnTBTClientState object indicated by the Hashtable parameter</p>
     *@param hash The Hashtable to use
     */    
    public OnTbtClientState(Hashtable<String, Object> hash) {
        super(hash);
    }
    /**
     * <p>Called to get the current state of TBT client</p>
     * @return {@linkplain TbtState} the current state of TBT client
     */    
    public TbtState getState() {
        Object obj = parameters.get(KEY_STATE);
        if (obj instanceof TbtState) {
        	return (TbtState)obj;
        } else if(obj instanceof String) {
        	return TbtState.valueForString((String) obj);
        }    	
    	return null;
    }
    /**
     * <p>Called to set the current state of TBT client</p>
     * @param state current state of TBT client
     */    
    public void setState( TbtState state ) {
        if (state != null) {
            parameters.put(KEY_STATE, state );
        } else {
        	parameters.remove(KEY_STATE);
        }
    }
} // end-class