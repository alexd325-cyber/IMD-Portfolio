using UnityEngine;
using UnityEngine.XR.Interaction.Toolkit;

public class Interaction : MonoBehaviour
{
    public void HoverEnter(HoverEnterEventArgs args)
    {
        HoverEnter();
    }
    public void HoverExit(HoverExitEventArgs args)
    {
        HoverExit();
    }
    public void Activate(ActivateEventArgs args)
    {
        Activate();
    }
    public void Deactivate(DeactivateEventArgs args)
    {
        Deactivate();
    }
    public void SelectEnter(SelectEnterEventArgs args)
    {
        SelectEnter();
    }
    public void SelectExit(SelectExitEventArgs args)
    {
        SelectExit();
    }
    protected virtual void HoverEnter()
    {
        Debug.Log($"{transform.parent.name}'s {name} hover entered");
    }
    protected virtual void HoverExit()
    {
        Debug.Log($"{transform.parent.name}'s {name} hover exited");
    }
    protected virtual void SelectEnter()
    {
        Debug.Log($"{transform.parent.name}'s {name} select entered");
    }
    protected virtual void SelectExit()
    {
        Debug.Log($"{transform.parent.name}'s {name} select exited");
    }
    protected virtual void Activate()
    {
        Debug.Log($"{transform.parent.name}'s {name} activated");
    }
    protected virtual void Deactivate()
    {
        Debug.Log($"{transform.parent.name}'s {name} deactivated");
    }
}
