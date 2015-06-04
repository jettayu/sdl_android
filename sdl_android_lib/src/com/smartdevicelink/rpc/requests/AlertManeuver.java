package com.smartdevicelink.rpc.requests;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.smartdevicelink.protocol.enums.FunctionId;
import com.smartdevicelink.proxy.RpcRequest;
import com.smartdevicelink.rpc.datatypes.SoftButton;
import com.smartdevicelink.rpc.datatypes.TtsChunk;

/**
 * This will bring up an alert with information related to the next navigation maneuver including potential voice
 * navigation instructions. Shown information will be taken from the ShowConstantTBT function
 * <p>
 * Function Group: Navigation
 * <p>
 * <b>HMILevel needs to be FULL, LIMITED or BACKGROUND</b>
 * <p>
 * 
 * @since SmartDeviceLink 2.0
 * @see ShowConstantTbt
 */
public class AlertManeuver extends RpcRequest{

    public static final String KEY_TTS_CHUNKS   = "ttsChunks";
    public static final String KEY_SOFT_BUTTONS = "softButtons";

    /**
     * Constructs a new AlertManeuver object
     */
    public AlertManeuver(){
        super(FunctionId.ALERT_MANEUVER.toString());
    }

    /**
     * <p>
     * Constructs a new AlertManeuver object indicated by the Hashtable parameter
     * </p>
     * 
     * @param hash
     *            The Hashtable to use
     */
    public AlertManeuver(Hashtable<String, Object> hash){
        super(hash);
    }

    /**
     * Gets the SoftButton List object
     * 
     * @return List<SoftButton> -a List<SoftButton> representing the List object
     * @since SmartDeviceLink 2.0
     */
    @SuppressWarnings("unchecked")
    public List<SoftButton> getSoftButtons(){
        if(parameters.get(KEY_SOFT_BUTTONS) instanceof List<?>){
            List<?> list = (List<?>) parameters.get(KEY_SOFT_BUTTONS);
            if(list != null && list.size() > 0){
                Object obj = list.get(0);
                if(obj instanceof SoftButton){
                    return (List<SoftButton>) list;
                }
                else if(obj instanceof Hashtable){
                    List<SoftButton> newList = new ArrayList<SoftButton>();
                    for(Object hashObj : list){
                        newList.add(new SoftButton((Hashtable<String, Object>) hashObj));
                    }
                    return newList;
                }
            }
        }
        return null;
    }

    /**
     * Sets the SoftButtons
     * 
     * @param softButtons
     *            a List<SoftButton> value
     *            <p>
     *            <b>Notes: </b><br/>
     *            <ul>
     *            <li>If omitted on supported displays, the alert will not have any SoftButton</li>
     *            <li>ArrayMin: 0</li>
     *            <li>ArrayMax: 4</li>
     *            </ul>
     * @since SmartDeviceLink 2.0
     */

    public void setSoftButtons(List<SoftButton> softButtons){
        if(softButtons != null){
            parameters.put(KEY_SOFT_BUTTONS, softButtons);
        }
        else{
            parameters.remove(KEY_SOFT_BUTTONS);
        }
    }

    /**
     * Gets TTSChunk[], the Array of type TTSChunk which, taken together, specify what is to be spoken to the user
     * 
     * @return List -a List<TTSChunk> value specify what is to be spoken to the user
     */
    @SuppressWarnings("unchecked")
    public List<TtsChunk> getTtsChunks(){
        if(parameters.get(KEY_TTS_CHUNKS) instanceof List<?>){
            List<?> list = (List<?>) parameters.get(KEY_TTS_CHUNKS);
            if(list != null && list.size() > 0){
                Object obj = list.get(0);
                if(obj instanceof TtsChunk){
                    return (List<TtsChunk>) list;
                }
                else if(obj instanceof Hashtable){
                    List<TtsChunk> newList = new ArrayList<TtsChunk>();
                    for(Object hashObj : list){
                        newList.add(new TtsChunk((Hashtable<String, Object>) hashObj));
                    }
                    return newList;
                }
            }
        }
        return null;
    }

    /**
     * Sets array of type TTSChunk which, taken together, specify what is to be spoken to the user
     * 
     * @param ttsChunks
     *            <p>
     *            <b>Notes: </b>Array must have a least one element
     */
    public void setTtsChunks(List<TtsChunk> ttsChunks){
        if(ttsChunks != null){
            parameters.put(KEY_TTS_CHUNKS, ttsChunks);
        }
        else{
            parameters.remove(KEY_TTS_CHUNKS);
        }
    }

}