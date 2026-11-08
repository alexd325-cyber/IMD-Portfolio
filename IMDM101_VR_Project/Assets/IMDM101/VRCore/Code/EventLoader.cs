using UnityEngine;
using UnityEngine.XR.Interaction.Toolkit.Interactables;

public class EventLoader : MonoBehaviour
{
    void Start()
    {
        XRBaseInteractable xrbi = GetComponent<XRBaseInteractable>();

        GameObject go = transform.GetChild(0).gameObject;

        if (go == null)
        {
            Debug.Log("You need to add a child object to {name}.");
        }
        else
        {
            Interaction[] interactions = go.GetComponents<Interaction>();

            foreach (Interaction interaction in interactions)
            {
                xrbi.hoverEntered.AddListener(interaction.HoverEnter);
                xrbi.hoverExited.AddListener(interaction.HoverExit);
                xrbi.activated.AddListener(interaction.Activate);
                xrbi.deactivated.AddListener(interaction.Deactivate);
                xrbi.selectEntered.AddListener(interaction.SelectEnter);
                xrbi.selectExited.AddListener(interaction.SelectExit);
            }
        }
    }
}
